package com.afaqy.ptt.data.features.channels

import com.afaqy.ptt.data.features.channels.mapper.ChannelsMapper
import com.afaqy.ptt.data.features.channels.store.ChannelsDataStoreFactory
import com.afaqy.ptt.domain.features.channels.model.ChannelModel
import com.afaqy.ptt.domain.features.channels.repository.ChannelsRepository
import io.reactivex.Observable
import javax.inject.Inject

class ChannelsDataRepository @Inject constructor(
    private val mapper: ChannelsMapper,
    private val factory: ChannelsDataStoreFactory
) : ChannelsRepository {

    override fun getChannels(authorization: String,page: Int): Observable<List<ChannelModel>> {
        return factory.getDataStore().getChannels(authorization,page).toObservable()
            .map {
                it.map { entity -> mapper.mapFromEntity(entity) }
            }
    }

}