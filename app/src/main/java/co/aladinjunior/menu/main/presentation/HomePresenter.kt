package co.aladinjunior.menu.main.presentation

import co.aladinjunior.menu.main.Home
import co.aladinjunior.menu.main.data.HomeCallback
import co.aladinjunior.menu.main.data.HomeRepository
import co.aladinjunior.menu.model.Snack

class HomePresenter(private var view: Home.View? = null,
                    private val repository: HomeRepository) : Home.Presenter {

    override fun getSnacks() {
        view?.displayProgress(true)
        repository.getSnacks(object : HomeCallback{
            override fun onSuccess(snacks: List<Snack>) {
                view?.showOnUi(snacks)
            }

            override fun onFailure() {
               // STILL NOTHING
            }

            override fun onComplete() {
                view?.displayProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}