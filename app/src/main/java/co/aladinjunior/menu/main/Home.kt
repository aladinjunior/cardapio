package co.aladinjunior.menu.main

import co.aladinjunior.menu.commom.base.PresenterBase
import co.aladinjunior.menu.model.Snack

interface Home {

    interface View {
        fun displayProgress(enabled: Boolean)
        fun showOnUi(listOfSnacks: List<Snack>)
    }

    interface Presenter : PresenterBase {
        fun getSnacks()
    }
}