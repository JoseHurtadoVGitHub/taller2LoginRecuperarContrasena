package co.edu.eam.mytestapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.edu.eam.mytestapp.databinding.ActivityRecuperarContrasenaBinding
import com.google.firebase.auth.FirebaseAuth

class recuperarContrasenaActivity : AppCompatActivity() {

    lateinit var  binding: ActivityRecuperarContrasenaBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        mAuth= FirebaseAuth.getInstance()
        binding= ActivityRecuperarContrasenaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonRecuperar.setOnClickListener{

            val email=binding.editTextTextEmailAddress.text.toString();
            Log.v("xd",email)
            if(email.isNotEmpty()){
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener{task->
                    if (task.isSuccessful) {
                        Log.v("Correcto", "Email sent.")
                        finish();
                    }
                }
            }

        }

    }
}