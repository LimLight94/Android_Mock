package com.lgcns.tct_template.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.lgcns.tct_template.data.model.UserData
import com.lgcns.tct_template.databinding.ActivityMainBinding
import com.lgcns.tct_template.presentation.adapter.UserListAdapter
import logcat.logcat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val adapter: UserListAdapter by lazy {
        UserListAdapter()
    }

    private val rowClickListener: (position: Int, eventType: UserListAdapter.EventType, item: UserData) -> Unit =
        { position, eventType, item ->
            logcat { "click position : $position, eventType: $eventType, item: $item" }
            if (eventType == UserListAdapter.EventType.PROFILE) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.USER_ID_ARGS, item.id)
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
        setUpObservers()

        viewModel.fetchUserList()
    }

    private fun setUpViews() {
        binding.rvMain.adapter = adapter
        adapter.setItemClickListener(rowClickListener)

        /**
         * 필요에 따라 주석 해제후 사용
         */
//        binding.rvMain.addItemDecoration(getDefaultDivider())

    }

    private fun setUpObservers() {
        viewModel.userListResponse.observe(this) {
            logcat { it.toString() }
            adapter.setItems(it.userList)
        }
    }

    /**
     * 기본 구분선
     */
    private fun getDefaultDivider(orientation: Int = LinearLayout.VERTICAL): DividerItemDecoration {
        return DividerItemDecoration(this, orientation)
    }
}