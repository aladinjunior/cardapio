package co.aladinjunior.menu

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedSnackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_snack)

        val icon = findViewById<ImageView>(R.id.detailed_snack_icon)
        val name = findViewById<TextView>(R.id.detailed_snack_name)
        val price = findViewById<TextView>(R.id.detailed_snack_price)
        val arrowBack = findViewById<ImageView>(R.id.return_arrow)


        val id =
            intent?.extras?.getInt("id") ?: throw IllegalStateException("nenhum id encontrado!")

        val previusPrice =
            intent?.extras?.getDouble("price") ?: throw IllegalStateException("nenhum preço encontrado!")
        val previusName =
            intent?.extras?.getString("name") ?: throw IllegalStateException("nenhum nome encontrado!")

        arrowBack.setOnClickListener {
            finish()
        }

        price.setText(resources.getString(R.string.detailed_price, previusPrice))

        if (id == 2){
            val rPrice = resources.getString(R.string.detailed_price, previusPrice)
            price.setText(rPrice)
            val rName = resources.getString(R.string.detailed_name, previusName)
            name.setText(rName)
            icon.setImageResource(R.drawable.hamburguer_normal)
        }

    }


}