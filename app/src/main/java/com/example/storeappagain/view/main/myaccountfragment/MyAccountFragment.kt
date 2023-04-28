package com.example.storeappagain.view.main.myaccountfragment

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentMyAccountBinding
import com.example.storeappagain.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth


class MyAccountFragment : Fragment() {
    private lateinit var binding: FragmentMyAccountBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mAuth = FirebaseAuth.getInstance()
        binding = FragmentMyAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogout.setOnClickListener {
            mAuth.signOut()
            startActivity(
                Intent(
                    requireActivity(),LoginActivity::class.java
            )
            )
            requireActivity().finish()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MyAccountFragment()
    }
}