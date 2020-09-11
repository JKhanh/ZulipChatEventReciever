package com.aibles.zulipeventtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aibles.zulipeventtest.api.EventResource
import com.aibles.zulipeventtest.api.MessageResource
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlin.properties.Delegates

class MessageViewModel(
    private val eventResource: EventResource,
    private val messageResource: MessageResource,
    private val dispatchers: AppDispatchers
): ViewModel() {

    lateinit var queueId: String
    var lastEventId by Delegates.notNull<Long>()

    private val _messages = MediatorLiveData<List<MessageResponse>>()
    val messages: LiveData<List<MessageResponse>> get() = _messages
    private var messageSource: LiveData<List<MessageResponse>> = MutableLiveData()

    fun registerEvent(eventRegister: EventRegister){
        val response =  eventResource.registerEventQueue(eventRegister).body()!!
        queueId = response.queueId
        lastEventId = response.lastEventId
    }

    fun getEvent(){
        val response = eventResource.getEvent()
        if(response.isSuccessful){
            val gson = GsonBuilder().create()
            val event = response.body()
            if(event?.result == "message"){
                val responseTypeToken = object : TypeToken<List<MessageResponse>>(){}
                val responseList = gson.fromJson<List<MessageResponse>>(gson.toJson(event.events), responseTypeToken.type)
                messageSource.value?.plus(responseList)
            }
        }
    }

}