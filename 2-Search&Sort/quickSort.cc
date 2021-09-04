#include <bits/stdc++.h>

void swap(int* arr, int i, int j) {
    if(i == j) return;
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
}

int partition1(int* arr, int l, int r)
{
    int pivot = arr[l];
    int i = l, j = r;
    while(l < r) {
        while(i < r && arr[i] <= pivot) {++i;}
        while(j > l && arr[j] >= pivot) {--j;}
        if(i >= j) { break;}
        swap(arr, i, j);
    }
    swap(arr, l, j);
    return j;
}
int partition2(int* arr, int l, int r) {
    int pivot = arr[l];
    while(l < r) {
	while(r > l && arr[r] >= pivot) --r;
	arr[l] = arr[r];
	while(l < r && arr[l] <= pivot) ++l;
	arr[r] = arr[l];
    }
    arr[l] = pivot;
    return l;
}

void quicksort(int* arr, int l, int r) {
    if(l <= r) {
	int pos = partition2(arr, l, r);
	quicksort(arr, l, pos-1);
	quicksort(arr, pos+1, r);
    }
}

int main() {
    int input[] = {3,1,5,7,8,4,6,2};
    int len = sizeof(input) / sizeof(int);
    quicksort(input, 0, len-1);
    for(int i = 0; i < len; ++i) {
	printf("%d,", input[i]);
    }
    puts("");
    return 0;
}


