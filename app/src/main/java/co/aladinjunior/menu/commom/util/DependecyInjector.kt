package co.aladinjunior.menu.commom.util

import co.aladinjunior.menu.detailed.DetailedSnack
import co.aladinjunior.menu.detailed.presentation.DetailedSnackPresenter
import co.aladinjunior.menu.main.data.FakeHomeRequest
import co.aladinjunior.menu.main.data.HomeRepository


object DependecyInjector {

    fun detailedSnackPresenter(view: DetailedSnack.View) : DetailedSnackPresenter{
        return DetailedSnackPresenter(view)
    }

    fun homeRepository() : HomeRepository{
        return  HomeRepository(FakeHomeRequest())
    }
}