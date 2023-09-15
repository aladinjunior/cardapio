package co.aladinjunior.menu.detailed

import co.aladinjunior.menu.commom.base.PresenterBase

interface DetailedSnack {

    interface View{
        fun setSnackOnUi(id: Int, price: Double, name: String, icon: Int)
    }

    interface Presenter : PresenterBase{

        fun loadOnUi(id: Int?, price: Double?, name: String?, icon: Int?)

    }

}