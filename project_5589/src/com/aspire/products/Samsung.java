package com.aspire.products;

public class Samsung extends Mobile {
int camera;
int expandableMemory;

public int getCamera() {
	return camera;
}




@Override
public String toString() {
	return "Samsung [camera=" + camera + ", expandableMemory=" + expandableMemory + ", brand=" + brand + ", model="
			+ model + ", stock=" + stock + ", price=" + price + ",  productid=" + productid + "]";
}




public void setCamera(int camera) {
	this.camera = camera;
}
public int getExpandablememory() {
	return expandableMemory;
}
public void setExpandablememory(int expandablememory) {
	this.expandableMemory = expandablememory;
}



}
