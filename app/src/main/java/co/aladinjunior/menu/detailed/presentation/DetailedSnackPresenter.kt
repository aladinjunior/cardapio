package co.aladinjunior.menu.detailed.presentation

import co.aladinjunior.menu.detailed.DetailedSnack

class DetailedSnackPresenter(private var view: DetailedSnack.View?) : DetailedSnack.Presenter {


    override fun loadOnUi(id: Int?, price: Double?, name: String?, icon: Int?) {
        view?.setSnackOnUi(id!!, price!!, name!!, icon!!)
    }

    override fun onDestroy() {
        view = null
    }


}