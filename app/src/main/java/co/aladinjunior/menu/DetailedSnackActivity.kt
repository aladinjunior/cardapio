package co.aladinjunior.menu

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedSnackActivity : AppCompatActivity() {

    private lateinit var icon: ImageView
    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var arrowBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_snack)

         icon = findViewById(R.id.detailed_snack_icon)
         name = findViewById(R.id.detailed_snack_name)
         price = findViewById(R.id.detailed_snack_price)
         arrowBack = findViewById(R.id.return_arrow)


        val id =
            intent?.extras?.getInt("id") ?: throw IllegalStateException("nenhum id encontrado!")

        val previusPrice =
            intent?.extras?.getDouble("price") ?: throw IllegalStateException("nenhum preço encontrado!")
        val previusName =
            intent?.extras?.getString("name") ?: throw IllegalStateException("nenhum nome encontrado!")


        arrowBack.setOnClickListener {
            finish()
        }

        setLayoutComponents(id, previusPrice, previusName)





    }

    private fun setLayoutComponents(id: Int, previusPrice: Double, previusName: String){

        if (id == 1){
            val rPrice = resources.getString(R.string.detailed_price, previusPrice)
            price.setText(rPrice)
            val rName = resources.getString(R.string.detailed_name, previusName)
            name.setText(rName)
            icon.setImageResource(R.drawable.hamburguer_black)
        }

        if (id == 2){
            val rPrice = resources.getString(R.string.detailed_price, previusPrice)
            price.setText(rPrice)
            val rName = resources.getString(R.string.detailed_name, previusName)
            name.setText(rName)
            icon.setImageResource(R.drawable.hamburguer_normal)
        }

    }


}