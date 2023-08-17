package co.aladinjunior.menu.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import co.aladinjunior.menu.R

data class Snack(
    val id: Int,
    @DrawableRes val icon: Int = R.drawable.hamburguer,
    val name: String,
    @StringRes val requiredTime: Int = R.string.required_time,
    @StringRes val price: Int

)


