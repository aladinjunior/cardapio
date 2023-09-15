package co.aladinjunior.menu.main.data

import co.aladinjunior.menu.model.Snack

interface HomeDataSource {

    fun getSnacks(callback: HomeCallback)

}