package com.afaqy.ptt.cache.features.recipes.mapper

import com.afaqy.ptt.cache.extentions.getOffsetDate
import com.afaqy.ptt.cache.features.login.mapper.CachedLoginMapper
import com.afaqy.ptt.cache.features.login.model.CachedLogin
import com.afaqy.ptt.cache.test.factory.RecipeDataFactory
import com.afaqy.ptt.data.features.recipes.model.RecipeEntity
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class CachedProfileMapperTest {

    private val mapper =
        CachedLoginMapper()

    @Test
    fun mapFromCachedMapsData() {
        val model = RecipeDataFactory.makeCachedRecipe()
        val entity = mapper.mapFromCached(model)

        assertEqualData(model, entity)
    }

    @Test
    fun mapToCachedMapsData() {
        val entity = RecipeDataFactory.makeRecipeEntity()
        val model = mapper.mapToCached(entity)

        assertEqualData(model, entity)
    }

    private fun assertEqualData(
        model: CachedLogin,
        entity: RecipeEntity
    ) {
        assertEquals(model.id, entity.id)
        assertEquals(model.author, entity.author)
        assertEquals(model.title, entity.title)
        assertEquals(model.description, entity.description)
        assertEquals(model.url, entity.url)
        assertEquals(model.urlToImage, entity.urlToImage)
        assertEquals(model.publishedAt, entity.publishedAt.getOffsetDate())
        assertEquals(model.content, entity.content)
        assertEquals(model.isBookmarked, entity.isBookmarked)
    }

}