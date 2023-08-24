package co.aladinjunior.menu.presentation

import co.aladinjunior.menu.data.Callback
import co.aladinjunior.menu.data.RemoteDataSource
import co.aladinjunior.menu.model.Snack
import co.aladinjunior.menu.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: RemoteDataSource = RemoteDataSource()
) : Callback {

    fun getSnacks() {
        dataSource.fakeRequest(this)
    }

    override fun onSuccess(response: List<Snack>) {

        view.getDataFromPresenter(response)

    }

    override fun onError() {
    }

    override fun onComplete() {
        view.hideProgress()
    }
}