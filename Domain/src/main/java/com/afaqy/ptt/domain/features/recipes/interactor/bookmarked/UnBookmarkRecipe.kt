package com.afaqy.ptt.domain.features.recipes.interactor.bookmarked

import com.afaqy.ptt.domain.base.executor.PostExecutionThread
import com.afaqy.ptt.domain.base.interactor.CompletableUseCase
import com.afaqy.ptt.domain.features.recipes.repository.RecipesRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import javax.inject.Inject

open class UnBookmarkRecipe @Inject constructor(
    private val recipesRepository: RecipesRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<UnBookmarkRecipe.Params>(postExecutionThread) {

    public override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params Can't be null !!")
        return recipesRepository.unBookmarkRecipe(params.recipeId)
    }

    data class Params(val recipeId:Long){
        companion object{
            fun forRecipe(recipeId:Long):Params{
                return Params(recipeId)
            }
        }
    }

}