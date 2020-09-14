package com.aibles.zulipeventtest

import android.util.Log
import androidx.lifecycle.*
import com.aibles.zulipeventtest.api.EventResource
import com.aibles.zulipeventtest.api.MessageResource
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class MessageViewModel(
    private val eventResource: EventResource,
    private val messageResource: MessageResource,
    private val dispatchers: AppDispatchers
): ViewModel() {

    var queueId: String? = null
    var lastEventId: Long = -1

    private val _messages = MediatorLiveData<List<MessageResponse>>()
    val messages: LiveData<List<MessageResponse>> get() = _messages
    private var messageSource: LiveData<List<MessageResponse>> = MutableLiveData()

    fun registerEvent(eventRegister: EventRegister){
        viewModelScope.launch {
            val response =  eventResource.registerEventQueue(eventRegister).awaitResponse()
            if(response.isSuccessful) {
                queueId = response.body()!!.queueId
                lastEventId = response.body()!!.lastEventId
                Log.d("Ahihi", queueId!!)

                getEvent()
            }
        }
    }

    private fun getEvent(){
        viewModelScope.launch(dispatchers.main) {
            _messages.removeSource(messageSource)
            val response = eventResource.getEvent(queueId!!, lastEventId)
            if(response.isSuccessful){
                val gson = GsonBuilder().create()
                val event = response.body()
                if(event?.result == "message"){
                    val responseTypeToken = object : TypeToken<List<MessageResponse>>(){}
                    val responseList = gson.fromJson<List<MessageResponse>>(gson.toJson(event.events), responseTypeToken.type)
                    messageSource.value?.plus(responseList)
                }
                lastEventId++
                getEvent()
            }
            _messages.addSource(messageSource){
                _messages.value = it
            }
        }
    }

}