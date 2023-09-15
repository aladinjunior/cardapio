package co.aladinjunior.menu.commom.util

import co.aladinjunior.menu.detailed.DetailedSnack
import co.aladinjunior.menu.detailed.presentation.DetailedSnackPresenter

object DependecyInjector {

    fun detailedSnackPresenter(view: DetailedSnack.View) : DetailedSnackPresenter{
        return DetailedSnackPresenter(view)
    }
}