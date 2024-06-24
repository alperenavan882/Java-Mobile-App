package com.alperenavan.recipes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ListFragment : Fragment() {

    var foodNameList = ArrayList<String>()
    var foodIdList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    fun sqlTakeData(){

        context?.let {

            try{

                val dataBase = it.openOrCreateDatabase("Foods", Context.MODE_PRIVATE, null)

                val cursor = dataBase.rawQuery("SELECT * FROM Foods",null)

                val foodNameIndex = cursor.getColumnIndex("foodname")

                val foodIdIndex = cursor.getColumnIndex("id")

                foodNameList.clear()
                foodIdList.clear()

                while(cursor.moveToNext()){
                    foodNameList.add(cursor.getString(foodNameIndex))
                    foodIdList.add(cursor.getInt(foodIdIndex))
                }

                cursor.close()


            }catch (e: Exception){

            }

        }

    }


}