package co.aladinjunior.menu.main.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.detailed.view.DetailedSnackActivity
import co.aladinjunior.menu.R
import co.aladinjunior.menu.databinding.SnackItemBinding
import co.aladinjunior.menu.model.Snack

class Adapter(
    private var snackList: List<Snack> = emptyList(),
    private val context: Context
) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    fun updateSnacks(snacks: List<Snack>) {
        snackList = snacks
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.snack_item, parent, false)
        return ViewHolder(SnackItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = snackList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return snackList.size
    }

    inner class ViewHolder(private val binding: SnackItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(snack: Snack) {
            with(binding) {
                snackTitle.text = snack.name
                iconCell.setImageResource(snack.icon)
                snackTimeRequired.setText(snack.requiredTime)
                snackPrice.setText(
                    context.resources.getString(
                        R.string.detailed_price,
                        snack.price
                    )
                )
            }

            binding.container.setOnClickListener {

                val i = Intent(context, DetailedSnackActivity::class.java)
                    .putExtra("id", snack.id)
                    .putExtra("price", snack.price)
                    .putExtra("name", snack.name)
                    .putExtra("icon", snack.icon)
                context.startActivity(i)


            }
        }

    }

}