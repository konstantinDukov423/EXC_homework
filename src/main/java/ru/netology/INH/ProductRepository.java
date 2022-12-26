package ru.netology.INH;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (this.findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getID() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

        public Product[] findAll () {
            return items;
        }

        public Product findById ( int id){
            Product[] tmp = new Product[items.length];
            for (int i = 0; i < items.length; i++) {
                if (items[i].ID == id) {
                    return items[i];
                }
            }
            return null;
        }
    }
