package dev.abdujabbor.codial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.data.MyData
import dev.abdujabbor.codial.databinding.ItemGroupBinding
import dev.abdujabbor.codial.db.Mydbbrowser
import dev.abdujabbor.codial.models.Groups
import dev.abdujabbor.codial.models.Students


class GroupsAdapter(
    val context: Context,
    private val arrayList: ArrayList<Groups>,
    val rvClickGroups: RVClickGroups
) : RecyclerView.Adapter<GroupsAdapter.VH>() {



    inner class VH(var itemView: ItemGroupBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun onBind(groups: Groups, position: Int) {
            itemView.findViewById<TextView>(R.id.tv_name).text = groups.name
            itemView.findViewById<TextView>(R.id.tv_countStudent).text =
                "O'quvchilar soni : ${1} ta"
            itemView.findViewById<CardView>(R.id.card_show).setOnClickListener {
                rvClickGroups.readGroup(groups)
            }
            itemView.findViewById<CardView>(R.id.card_edit).setOnClickListener {
                rvClickGroups.editGroups(groups, position)
            }
            itemView.findViewById<CardView>(R.id.card_delete).setOnClickListener {
                rvClickGroups.deleteGroups(groups)
            }
        }
    }


    interface RVClickGroups {
        fun readGroup(groups: Groups) {
            //TODO(SHOW GROUPS)
        }

        fun editGroups(groups: Groups, position: Int) {
            //TODO(EDIT GROUPS)
        }

        fun deleteGroups(groups: Groups) {
            // TODO(DELETE GROUPS)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayList[position], position)
    }

    override fun getItemCount(): Int = arrayList.size
}