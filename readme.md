
# RecyclerViewUpdater

![header](https://raw.githubusercontent.com/emirhankolver/RecyclerViewUpdater/master/assets/banner.png)

Achieve smooth animations of **ListAdapter** class without changing your already 
existing **RecyclerView Adapters**. Just say goodbye to all **notifyDataSetChanged()** methods
in your project!





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
