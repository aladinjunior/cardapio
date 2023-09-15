package co.aladinjunior.menu.main.data

import co.aladinjunior.menu.model.Snack

interface HomeCallback {

    fun onSuccess(snacks: List<Snack>)
    fun onFailure()
    fun onComplete()
}