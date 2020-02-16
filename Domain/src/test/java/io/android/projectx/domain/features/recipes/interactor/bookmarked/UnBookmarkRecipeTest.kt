package io.android.projectx.domain.features.recipes.interactor.bookmarked

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.android.projectx.domain.base.executor.PostExecutionThread
import io.android.projectx.domain.features.recipes.repository.RecipesRepository
import io.android.projectx.domain.test.factory.DataFactory
import io.reactivex.Completable
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.IllegalArgumentException

class UnBookmarkRecipeTest {

    private lateinit var unBookmarkRecipe: UnBookmarkRecipe
    @Mock
    lateinit var recipesRepository: RecipesRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        unBookmarkRecipe = UnBookmarkRecipe(recipesRepository, postExecutionThread)
    }

    @Test
    fun unBookmarkRecipeCompletes() {
        stubUnBookmarkRecipe(Completable.complete())
        val testObserver = unBookmarkRecipe.buildUseCaseCompletable(
            UnBookmarkRecipe.Params.forRecipe(DataFactory.uniqueId())
        ).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun unBookmarkRecipeThrowException() {
        unBookmarkRecipe.buildUseCaseCompletable().test()
    }

    private fun stubUnBookmarkRecipe(completable: Completable) {
        whenever(recipesRepository.unBookmarkRecipe(any()))
            .thenReturn(completable)
    }

}