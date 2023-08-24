package co.aladinjunior.menu.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.DetailedSnackActivity
import co.aladinjunior.menu.R
import co.aladinjunior.menu.model.Snack

class Adapter(
    private val snackList: List<Snack>,
    private val context: Context
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.snack_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = snackList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return snackList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(snack: Snack) {
            val snackTitle = itemView.findViewById<TextView>(R.id.snack_title)
            val snackPrice = itemView.findViewById<TextView>(R.id.snack_price)
            val snackIcon = itemView.findViewById<ImageView>(R.id.icon_cell)
            val requiredSnackTime = itemView.findViewById<Button>(R.id.snack_time_required)
            snackIcon.setImageResource(snack.icon)
            requiredSnackTime.setText(snack.requiredTime)
            snackTitle.setText(snack.name)
            val x = context.resources.getString(R.string.detailed_price, snack.price)
            snackPrice.setText(x)


            val container = itemView as RelativeLayout
            container.setOnClickListener {
                val i = Intent(context, DetailedSnackActivity::class.java)
                    .putExtra("id", snack.id)
                    .putExtra("price", snack.price)
                    .putExtra("name", snack.name)
                context.startActivity(i)


            }
        }

    }

}