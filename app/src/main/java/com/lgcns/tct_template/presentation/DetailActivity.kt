package com.lgcns.tct_template.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lgcns.tct_template.databinding.ActivityDetailBinding
import com.lgcns.tct_template.util.getDrawableId

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()
        setUpObservers()

        val userId = intent.getLongExtra(USER_ID_ARGS, -1)
        viewModel.fetchFromNetwork(userId)
    }

    private fun setUpViews() {
        // 필요한거 작성
    }

    @SuppressLint("SetTextI18n")
    private fun setUpObservers() {
        viewModel.userData.observe(this) {userData->
            binding.ivDetailProfile.setImageResource(this.getDrawableId(userData.imageFile))
            binding.tvDetailName.text = userData.name
            binding.tvDetailPhoneNum.text = userData.phoneNum
            binding.tvDetailAge.text = "나이 : ${userData.age}"
            binding.tvDetailAddress.text = "주소 : ${userData.address}"
        }

    }

    companion object {
        const val USER_ID_ARGS = "UserID"
    }
}