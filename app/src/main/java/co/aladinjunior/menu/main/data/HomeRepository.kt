package co.aladinjunior.menu.main.data

import co.aladinjunior.menu.model.Snack

class HomeRepository(private val dataSource: HomeDataSource) {

    fun getSnacks(callback: HomeCallback){
        dataSource.getSnacks(callback)
    }
}