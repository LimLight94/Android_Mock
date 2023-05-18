package com.lgcns.tct_template.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lgcns.tct_template.data.model.UserData
import com.lgcns.tct_template.databinding.ItemUsersBinding
import com.lgcns.tct_template.util.getDrawableId
import com.lgcns.tct_template.util.removeExtension

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    enum class EventType {
        ROW, PROFILE
    }

    private var clickAction: ((position: Int, type: EventType, item: UserData) -> Unit)? = null
    private val items: MutableList<UserData> = mutableListOf()

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<UserData>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setItemClickListener(action: (position: Int, type: EventType, item: UserData) -> Unit) {
        this.clickAction = action
    }

    inner class UserListViewHolder(
        private val binding: ItemUsersBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: UserData) {
            setViews(item)
            setListener(item)
        }

        private fun setListener(item: UserData) {
            if (clickAction != null) {
                binding.groupItemUsersContract.setOnClickListener {
                    item.isExpanded = !item.isExpanded
                    binding.groupItemUsersExpand.isVisible = item.isExpanded
                    clickAction?.invoke(adapterPosition, EventType.ROW, item)
                }
                binding.ivItemUsersProfile.setOnClickListener {
                    clickAction?.invoke(adapterPosition, EventType.PROFILE, item)
                }
            }
        }

        private fun setViews(item: UserData) {
            val context = binding.ivItemUsersProfile.context
            val fileName = item.imageFile.removeExtension()
            val imageId = context.getDrawableId(fileName)
            Glide.with(context)
                .load(imageId)
                .circleCrop()
                .into(binding.ivItemUsersProfile)
            binding.tvItemUsersName.text = item.name
            binding.tvItemUsersAge.text = "나이: ${item.age}"
            binding.tvItemUsersPhone.text = "연락처 : ${item.phoneNum}"
            binding.tvItemUsersAddress.text = "주소 : ${item.address} ${item.address}"
            binding.groupItemUsersExpand.isVisible = item.isExpanded
        }
    }
}