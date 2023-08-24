package co.aladinjunior.menu.data

import co.aladinjunior.menu.model.Snack

interface Callback {
    fun onSuccess(response: List<Snack>)
    fun onError()
    fun onComplete()
}