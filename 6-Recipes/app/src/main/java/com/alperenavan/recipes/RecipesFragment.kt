package com.alperenavan.recipes


import android.Manifest
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Nullable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.alperenavan.recipes.databinding.ActivityMainBinding
import com.alperenavan.recipes.databinding.FragmentRecipesBinding
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream


class RecipesFragment : Fragment() {



    private lateinit var binding: FragmentRecipesBinding



    var choosenPicture : Uri? = null
    var choosenBitmap : Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRecipesBinding.inflate(inflater, container, false)

        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    fun chooseImage(view: View){


        activity.let {

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //There is no permission already so we need to take permission
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
                //If it doesnt work use READ_EXTERNAL_STORAGE

            } else {
                //There is already permission so, there is no need to take permission again
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent, 2)

            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){

            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //We have permission now
                val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent,2)
            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){

            choosenPicture = data.data

        }

        try{

            context?.let {
                if(choosenPicture != null){
                    if(Build.VERSION.SDK_INT >= 33){
                        val source = ImageDecoder.createSource(it.contentResolver,choosenPicture!!)
                        choosenBitmap = ImageDecoder.decodeBitmap(source)
                        binding.imageView2.setImageBitmap(choosenBitmap)

                    }else{
                        choosenBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver,choosenPicture)
                        binding.imageView2.setImageBitmap(choosenBitmap)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    fun saveImage(view: View) {

        //Saves to SQLite
        val foodName = binding.foodNameText.text.toString()
        val foodRecipe = binding.foodRecipeText.text.toString()

        if (choosenBitmap != null){
            val smallBitmap = createSmallBitmap(choosenBitmap!!, maximumSize = 300)

            val outputStream = ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
            val byteArray = outputStream.toByteArray()

            try{

                context?.let {
                    val dataBase = it.openOrCreateDatabase("Foods",Context.MODE_PRIVATE,null)

                    dataBase.execSQL("CREATE TABLE IF NOT EXISTS foods(id INTEGER PRIMARY KEY,foodname VARCHAR,foodmaterials VARCHAR,picture BLOB)")

                    val sqlString = "INSERT INTO foods(foodname,foodmaterials,picture)VALUES(?,?,?)"
                    val statement = dataBase.compileStatement(sqlString)
                    statement.bindString(1,foodName)
                    statement.bindString(2,foodRecipe)
                    statement.bindBlob(3,byteArray)
                    statement.execute()


                }

            }catch (e: Exception){
                e.printStackTrace()
            }

            val action = RecipesFragmentDirections.actionRecipesFragmentToListFragment()
            Navigation.findNavController(view).navigate(action)

        }



    }

    fun createSmallBitmap(userchoosedBitmap: Bitmap,maximumSize: Int) : Bitmap{

        var width = userchoosedBitmap.width
        var height = userchoosedBitmap.height
        val bitmapRatio :Double = width.toDouble() / height.toDouble()

        if(bitmapRatio > 1){
            //Picture is horizontal

            width = maximumSize
            val shorterHeight = width / bitmapRatio
            height = shorterHeight.toInt()
        }else{
            //Picture is vertical
            height = maximumSize
            val shorterWidth = width * bitmapRatio
            width = shorterWidth.toInt()
        }

        return Bitmap.createScaledBitmap(userchoosedBitmap,width,height,true)
    }

}


