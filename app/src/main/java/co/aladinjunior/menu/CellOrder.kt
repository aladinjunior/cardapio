package co.aladinjunior.menu

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import java.util.*

data class CellOrder(
    @DrawableRes val orderIcon: Int = R.drawable.hamburguer,
     val snackTitle: String,
    @StringRes val snackRequiredTime: Int = R.string.required_time,
    @StringRes val snackPrice: Int

)


