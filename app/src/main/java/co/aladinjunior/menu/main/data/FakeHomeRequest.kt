package co.aladinjunior.menu.main.data

import android.os.Handler
import android.os.Looper
import co.aladinjunior.menu.R
import co.aladinjunior.menu.model.Snack

class FakeHomeRequest : HomeDataSource {


    override fun getSnacks(callback: HomeCallback) {

        Handler(Looper.getMainLooper()).postDelayed({
            val response = listOf(
                Snack(
                    id = 1,
                    icon = R.drawable.hamburguer_black,
                    name = "Hambúrguer Black",
                    price = 30.0
                ),
                Snack(
                    id = 2,
                    icon = R.drawable.hamburguer_normal,
                    name = "Hambúrguer Simples",
                    price = 20.0
                )
            )
            callback.onSuccess(response)
            callback.onComplete()
        }, 2000)

    }
}