**Reto Tecnico para Tribal**

Aplicación para mostrar categorias con la API de mocks https://api.chucknorris.io/jokes sugerida en el reto

---

## Descripción

Esta aplicación lista unas categorias usando la API de chucknorris.io. La aplicación está desarrollada utilizando buenas prácticas de programación, arquitectura limpia, MVVM y coroutines.

### Estructura

La aplicación está organizada en las siguientes capas:

* **Presentación**: Esta capa es responsable de la interfaz de usuario.
* **Dominio**: Esta capa es responsable de la lógica de negocio
* **Infraestructura**: Esta capa es responsable de la comunicación con el back-end (API's).

---

## Presentación

La capa de presentación es responsable de la interfaz de usuario. Se compone de los siguientes paquetes:

* **adapter** En este paquete se encuentran los adaptadores y los viewHolders para resolver las categorias.
* **listener** En este paquete se encuentran los listeners para las categorias.
* **ui** En este paquete se encuentran todas las actividades y los recursos base de la aplicación.
* **viewmodels** En este paquete se encuentran los viewmodels para las categorias.

---

## Infraestructura

La capa de infraestructura es responsable de la comunicación con el back-end (API's). También es el puente entre la capa de dominio y la capa de presentación.

* **di** En este paquete se encuentra la inyección de dependencias.
* **mapper** En este paquete se encuentran los mappers que se encargan de convertir los datos de la capa de dominio a los datos de la capa de infraestructura y viceversa.
* **repository** En este paquete se encuentran las implementaciones de los repositorios de la capa de dominio.
* **manager** En este paquete se encuentran los endpoint y los administradores de los endpoint.

---

## Dominio

La capa de dominio es responsable de la lógica de negocio de la aplicación. Esta capa se encarga de definir los modelos de datos, las reglas de negocio y los servicios que se utilizan en la aplicación.

* **repository** En este paquete se encuentran los contratos de los repositorios que se utilizan en la capa de dominio.
* **services** En este paquete se encuentran los servicios que implementan la lógica de negocio de la aplicación.

---

## Dependencias

Se muestra a continuación fragmento de codigo de se declaran las dependencias:


``` groovy

dependencies {

    //ViewModel
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
    implementation "androidx.activity:activity-ktx:1.8.2"
    implementation "androidx.fragment:fragment-ktx:1.6.2"

    //Dependency Injection
    api "com.google.dagger:hilt-android:2.48"
    kapt "com.google.dagger:hilt-android-compiler:2.48"
    kapt "androidx.hilt:hilt-compiler:1.1.0"

    //Retrofit
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.3"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1"
    
    implementation project(":app")
    implementation project(":domain")
    implementation project(":infrastructure")
}

```

---

