package com.afaqy.ptt.domain.features.profile.interactor

import com.afaqy.ptt.domain.base.executor.PostExecutionThread
import com.afaqy.ptt.domain.base.interactor.ObservableUseCase
import com.afaqy.ptt.domain.features.profile.model.ProfileModel
import com.afaqy.ptt.domain.features.profile.repository.ProfileRepository
import io.reactivex.Observable
import java.lang.IllegalArgumentException
import javax.inject.Inject

open class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProfileModel, ProfileUseCase.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProfileModel> {
        if (params == null) throw IllegalArgumentException("Params can't be null !!")
        return profileRepository.getProfile(params.authorization)
    }

    data class Params constructor(val authorization: String) {
        companion object {
            fun forChannels(authorization: String): Params {
                return Params(authorization)
            }
        }
    }

}