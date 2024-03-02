package com.example.luxeglow.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.luxeglow.models.Product
import com.example.luxeglow.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class ProductViewModel(var navController: NavController, var context: Context) {
    var authViewModel: AuthViewModel
    var progress: ProgressDialog

    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()) {
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait....")
    }

    fun uploadProduct(name: String, description: String, price: String, filePath: Uri) {
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Products/$productId")

        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                //Save data to db
                storageRef.downloadUrl.addOnCompleteListener {
                    var imageUrl = it.toString()
                    var product = Product(name, description, price, imageUrl)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Products")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful) {
                        } else {
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }


            }
        }

        fun allProducts(
            product: MutableState<Product>,
            products: SnapshotStateList<Product>
        ): SnapshotStateList<Product> {
            progress.show()
            var ref = FirebaseDatabase.getInstance().getReference()
                .child("Products")
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(p0: DataSnapshot) {
                    products.clear()
                    for (snap in p0.children) {
                        var retrievedProduct = snap.getValue(Product::class.java)
                        product.value = retrievedProduct!!
                        products.add(retrievedProduct)
                    }
                    progress.dismiss()

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
                }
            })

            return products

        }

        fun deleteProduct(productdescription: String) {
            var ref = FirebaseDatabase.getInstance().getReference()
                .child("Products/$productdescription")
            ref.removeValue()
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

