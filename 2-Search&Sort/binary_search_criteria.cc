#include <bits/stdc++.h>

const int MAX_N = 1000005;
int arr[MAX_N];

int cmp(const void* a1, const void* a2);

int lower_binarySearch(int* arr, int len, int tar) {
    int l = 0, r = len-1, m;
    while(l <= r) {
	m = l + (r-l)/2;
	if(arr[m] >= tar) {
	    r = m - 1;
	} else {
	    l = m + 1;
	}
    }
    return r;
}

int upper_binarySearch(int* arr, int len, int tar) {
    int l=0, r=len-1, m;
    while(l <= r) {
	m = l + (r-l)/2;
	if(arr[m] > tar) {
	    r = m - 1;
	} else {
	    l = m + 1;
	}
    }
    return l;
}

int main() {
    int N, T;
    while(scanf("%d%d", &N, &T) != EOF) {
	for(int i=0; i<N; i++) {
	    scanf("%d", arr+i);
	    printf("%d,", arr[i]);
	}
	putchar('\n');
	int low = lower_binarySearch(arr, N, T);
	int high = upper_binarySearch(arr, N, T);
	if(low+1 >= high) {
	    printf("target %d not found!\n", T);
	} else {
	    printf("arr[%d]~arr[%d]=%d.\n", low+1, high-1, T);
	}
    }
    return 0;
}

int cmp(const void* a1, const void* a2) {
    return *(int*)a1 - *(int*)a2;
}
