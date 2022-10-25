
# RecyclerViewUpdater

![header](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/banner.png)
[![](https://visitcount.itsvg.in/api?id=RecyclerViewUpdater&label=Project%20Views&color=0&icon=5&pretty=true)](https://visitcount.itsvg.in)
[![](https://www.codefactor.io/repository/github/emirhankolver/RecyclerViewUpdater/badge)](https://www.codefactor.io/repository/github/emirhankolver/RecyclerViewUpdater)
[![](https://jitpack.io/v/emirhankolver/RecyclerViewUpdater/month.svg)](https://jitpack.io/v/emirhankolver/RecyclerViewUpdater)

Achieve smooth animations of **ListAdapter** class without changing your already 
existing **RecyclerView Adapters**. Just say goodbye to all **notifyDataSetChanged()** methods
in your project!

## Installation

Step 1. Add the JitPack repository to your settings.gradle file

```gradle
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line
    }
}
```

Step 2. Add The GlobalExceptionHandler Dependency to your build.gradle(app) file.

```gradle
dependencies {
    implementation 'com.github.emirhankolver:RecyclerViewUpdater:1.0.0'
}
```


## Usage/Examples

Example Usage 1
```kotlin
class RowsAdapter : RecyclerView.Adapter<RowsAdapter.VH>() {
    
    var list = mutableListOf<Data>()
        set(value) {
            // field = value
            // notifyDataSetChanged() | RecyclerViewUpdater will handle this.
            RecyclerViewUpdater(
                field,
                value,
                { oldData, newData -> oldData.id == newData.id },
                { oldData, newData -> oldData.name == newData.name }
            ).updateList(this)
        }
 
```

Example Usage 2
```kotlin
class RowsAdapter : RecyclerView.Adapter<RowsAdapter.VH>() {
    
    val list = mutableListOf<Data>()

    fun setList(newList:MutableList<Data>) {
        // list.clear()
        // list.addAll(newList)
        // notifyDataSetChanged() | RecyclerViewUpdater will handle this.
        RecyclerViewUpdater(
                list,
                newList,
                { oldData, newData -> oldData.id == newData.id },
                { oldData, newData -> oldData.name == newData.name }
            ).updateList(this)
    }
 
```


## Screenshots
### With Cards
With RecyclerViewUpdater | Without RecyclerViewUpdater
--- | ---
![](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/cards_animated.gif) | ![](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/cards_non_animated.gif)


### With Rows
With RecyclerViewUpdater | Without RecyclerViewUpdater
--- | ---
![](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/rows_animated.gif) | ![](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/rows_non_animated.gif)


## License

[MIT](https://choosealicense.com/licenses/mit/)

#### Emirhan KOLVER © 2022
