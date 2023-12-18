package com.example.exam5.cource

import android.util.Log.d
import androidx.lifecycle.lifecycleScope
import com.example.exam5.BaseFragment
import com.example.exam5.databinding.FragmentCourceBinding
import com.example.exam5.utils.RetrofitInstance
import kotlinx.coroutines.launch
import java.io.IOException


class CourceFragment : BaseFragment<FragmentCourceBinding>(FragmentCourceBinding::inflate) {

    private lateinit var activeCources: MutableList<ActiveCourse>
    private lateinit var newCources: MutableList<NewCourse>

    override fun setup() {
        activeCources = mutableListOf()
        newCources = mutableListOf()
        getActiveCources()
        getNewCources()

    }

    override fun setupListeners() {

    }

    override fun bindData() {

    }


    private fun getNewCources(){
        lifecycleScope.launch() {
            val response = try {
                RetrofitInstance.api.getUsers()
            }catch (e: IOException){
                return@launch
            }catch (e: retrofit2.HttpException){
                return@launch
            }
            if(response.isSuccessful && response.body() != null){
                d("GetData", "${response.body()!!.new_courses}")

                for (cource in response.body()!!.new_courses){
                    newCources.add(NewCourse(
                        duration = cource.duration,
                        icon_type = cource.icon_type,
                        id = cource.id,
                        main_color = cource.main_color,
                        question = cource.question,
                        title = cource.title
                    ))
                }
                d("GetNcourcesList", "${newCources}")


//                with(binding){
//                    usersRecyclerView.adapter = adapter
//                    usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//                    adapter.submitList(users)
//                }
//                d("UsersList", "${users}")
            }
        }
    }


    private fun getActiveCources(){
        lifecycleScope.launch() {
            val response = try {
                RetrofitInstance.api.getUsers()
            }catch (e: IOException){
                return@launch
            }catch (e: retrofit2.HttpException){
                return@launch
            }
            if(response.isSuccessful && response.body() != null){
                d("GetData", "${response.body()!!.active_courses}")

                for (cource in response.body()!!.active_courses){
                    activeCources.add(ActiveCourse(
                        background_color_present = cource.background_color_present,
                        booking_time = cource.booking_time,
                        id = cource.id,
                        image = cource.image,
                        main_color = cource.main_color,
                        play_button_color_present = cource.play_button_color_present,
                        progress = cource.progress,
                        title = cource.title
                        ))
                }
                d("GetAcourcesList", "${activeCources}")


//                with(binding){
//                    usersRecyclerView.adapter = adapter
//                    usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//                    adapter.submitList(users)
//                }
//                d("UsersList", "${users}")
            }
        }
    }

}