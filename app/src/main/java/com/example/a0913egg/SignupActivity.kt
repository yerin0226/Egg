package com.example.a0913egg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {


    lateinit var signup: Button

    lateinit var name: String
    lateinit var id: String
    lateinit var email: String
    lateinit var pw: String
    lateinit var grade: String
    lateinit var hclass: String

    var Auth: FirebaseAuth? = null
    var Firestore: FirebaseFirestore? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        Auth = FirebaseAuth.getInstance()
        Firestore = FirebaseFirestore.getInstance()



        signup = findViewById(R.id.signup)

        ingrade.setOnCheckedChangeListener { radioGroup, checkedid ->
            when(checkedid){
                R.id.ingrade1 -> grade = "1"
                R.id.ingrade2 -> grade = "2"
                R.id.ingrade3 -> grade = "3"
            }
        }

        inclass.setOnCheckedChangeListener { radioGroup, checkedid ->
            when(checkedid){
                R.id.inclass1 -> hclass = "A"
                R.id.inclass2 -> hclass = "B"
                R.id.inclass3 -> hclass = "C"
            }
        }

        signup.setOnClickListener{
            //파이어베이스 이메일 회원가입 먼저 처리 후 uid를 활용
            Signup()

        }

    }

    fun Signup() {
        Auth?.createUserWithEmailAndPassword(inemail.text.toString(),inpw.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    // 사용자 계정 만들기
                    Toast.makeText(this, "회원가입 성공",Toast.LENGTH_LONG).show()
                    signup(inname.text.toString(),inid.text.toString(),grade,hclass,inemail.text.toString(),inpw.text.toString())
                    moveSigninPage(task.result?.user)
                } else if(task.exception?.message.isNullOrEmpty()) {
                    // 에러 메시지 보여 줌
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                } else if (inpw.text.toString().length < 6){
                    //W/System: Ignoring header X-Firebase-Locale because its value was null.
                    //비밀번호를 6글자 이상 입력하지 않으면 오류가 난다, 추후 사용자가 확인할 수 있게 화면에 표시
                    Toast.makeText(this, "비밀 번호를 6자 이상 설정해 주세요", Toast.LENGTH_LONG).show()
                } else{

                }
            }
    }

    private fun moveSigninPage(user: FirebaseUser?) {
    // 파이어베이스 유저 상태가 있을 경우 다음 페이지로 넘어갈 수 있음
        if(user != null) {
            startActivity(Intent(this, SigninActivity::class.java))
        }
    }


    private fun signup(name: String, id: String, grade: String, hclass: String, email: String, pw: String){
        if(true){

            val database : FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef : DatabaseReference = database.getReference("HywUser")

            var input = HywUser(name,id, grade, hclass, email, pw, Auth?.uid.toString())

            myRef.child(Auth?.uid.toString()).setValue(input)
        }
    }
}