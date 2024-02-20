package com.ymd.challengetribal.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ymd.challengetribal.R
import com.ymd.challengetribal.adapter.CategoryAdapter
import com.ymd.challengetribal.listener.CategoryListener
import com.ymd.challengetribal.viewmodel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CategoryListener {

    private lateinit var categoryViewModel: CategoryViewModel

    private lateinit var categoryAdapter: CategoryAdapter
    private val categoryLayoutManager: GridLayoutManager by lazy { GridLayoutManager(this, 1) }
    private var categoryList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        observerViewModel()
        initUi()
    }

    private fun initViewModel() {
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        categoryViewModel.getAllCategory()
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                categoryViewModel.categoryList.collect { categoryList ->
                    categoryList?.let {
                        processCategory(it)
                    }
                }
            }
        }
    }

    private fun initUi() {
        val categoryRecyclerView: RecyclerView = findViewById(R.id.category_recyclerview)
        categoryRecyclerView.apply {
            layoutManager = categoryLayoutManager
            categoryAdapter = CategoryAdapter(categoryList, this@MainActivity)
            adapter = categoryAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun processCategory(categoryList: List<String>) {
        this.categoryList.apply {
            clear()
            addAll(categoryList)
        }
        categoryAdapter.notifyDataSetChanged()
    }

    override fun onSelectCategory(category: String) {
        Toast.makeText(this, "Has seleccionado la categoria: $category", Toast.LENGTH_SHORT).show()
    }


}

/*

Objetivo:

Se debe realizar el consumo de un API donde se demuestre el conocimiento y manejo de los siguientes puntos:

-	Patrón MVVM.
-	Inyección de dependencias con Dagger Hilt.
-	Corrutinas.
-	Estructura basada en Clean Architecture.
-	Consumo de API.
-	Koltin Flow (Opcional)
-	Jetpack Compose (Opcional)
Descripción:

Se debe realizar el consumo del API “categories” del siguiente enlace https://api.chucknorris.io/. Con la finalidad de mostrar en una lista las categorías que retorna el API.


Instrucciones:

Para el apartado visual se puede utilizar tanto XML como Jetpack Compose.

Se puede utilizar material de apoyo para el listado de dependencias a utilizar en el build.gradle.

Se puede consultar documentación en la web.

Al ser un LiveCoding es obligatorio tener encendida la cámara y comparti
Jean Alvarez


Recomendaciones:

Hacer hincapié en el apartado funcional del ejercicio (implementando buenas prácticas y los puntos antes mencionados) y no tanto en el apartado visual (UI).

Evitar copiar fragmentos de código de proyectos anteriores relacionados con los puntos mencionados como objetivos de la prueba.

Jean Alvarez


jalvarez@tribalworldwide.gt
cpena@tribalworldwide.gt
erick.espejel@tribalworldwide.gt

 */