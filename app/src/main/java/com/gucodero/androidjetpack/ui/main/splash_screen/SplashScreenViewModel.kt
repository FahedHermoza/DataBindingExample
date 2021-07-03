package com.gucodero.androidjetpack.ui.main.splash_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gucodero.androidjetpack.R
import com.gucodero.androidjetpack.ui.base.BaseViewModel
import com.gucodero.androidjetpack.ui.components.binding.BannerUIEntity
import com.gucodero.androidjetpack.ui.main.splash_screen.models.SplashScreenUIEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenViewModel: BaseViewModel() {

    /**
     * LiveData
     */
    val countLiveData = MutableLiveData(0) //
    val colorLiveData = MutableLiveData<Int>() //
    val bannerUIEntityLiveData = MutableLiveData<BannerUIEntity>()

    /**
     * BaseObservable
      */
    val uiLiveData = MutableLiveData<SplashScreenUIEntity>()
    val ui get() = uiLiveData.value

    init {
        //initExample1()
        initExample2()
    }

    /**
     * Ejemplo de uso de data binding usando MutableLiveData de manera directa
     */
    private fun initExample1(){
        initCount()
        initBanner()
    }


    private fun initBanner(){
        bannerUIEntityLiveData.value = BannerUIEntity(
            radius = 5f,
            text = "Banner 1",
            borderWidth = 5f,
            borderColor = R.color.purple_200
        )
    }

    private fun initCount(){
        viewModelScope.launch(NonCancellable) {
            for (i in 1 .. 6){
                delay()
                countLiveData.value = i
            }
            delay()
            val colors = listOf(
                R.color.purple_200,
                R.color.purple_500,
                R.color.purple_700,
                R.color.black
            )
            colors.forEach {
                colorLiveData.value = it
                delay()
            }
        }
    }

    /**
     * Ejemplo usando BaseObservable para enlazar con layout
     */
    private fun initExample2(){
        initUI()
        initCount2()
    }

    private fun initUI(){
        uiLiveData.value = SplashScreenUIEntity(
            count = 0,
            color = R.color.purple_200,
            bannerList = responseList
        )
    }

    private fun initCount2(){
        viewModelScope.launch(NonCancellable) {
            for (i in 1 .. 6){
                delay()
                ui?.count = i
            }
            delay()
            val colors = listOf(
                R.color.purple_200,
                R.color.purple_500,
                R.color.purple_700,
                R.color.black
            )
            colors.forEach {
                ui?.color = it
                ui?.bannerList?.forEach { uiEntity ->
                    uiEntity.borderColor = it
                }
                delay()
            }
        }
    }

    private suspend fun delay() = withContext(Dispatchers.IO){
        Thread.sleep(1000)
    }

    companion object {
        val responseList = listOf(
            BannerUIEntity(
                radius = 5f,
                text = "Banner 1",
                borderWidth = 5f,
                borderColor = R.color.purple_200
            ),
            BannerUIEntity(
                radius = 10f,
                text = "Banner 2",
                borderWidth = 10f,
                borderColor = R.color.purple_200
            ),
            BannerUIEntity(
                radius = 15f,
                text = "Banner 3",
                borderWidth = 15f,
                borderColor = R.color.purple_200
            )
        )
    }

}