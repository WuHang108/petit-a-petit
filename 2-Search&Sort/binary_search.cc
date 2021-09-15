#include <bits/stdc++.h>

const int MAX_N = 1000005;
int arr[MAX_N];

int cmp(const void* a1, const void* a2);

int binarySearch(int* arr, int len, int tar) {
    int l = 0, r = len-1, m;
    while(l <= r) {
	m = l + (r-l)/2;
	if(arr[m] == tar) {
	    return m;
	} else if(arr[m] > tar) {
	    r = m - 1;
	} else {
	    l = m + 1;
	}
    }
    return -1;
}

int main() {
    int N, T;
    while(scanf("%d%d", &N, &T) != EOF) {
	for(int i=0; i<N; i++) {
	    scanf("%d", arr+i);
	    printf("%d,", arr[i]);
	}
	putchar('\n');
	int pos = binarySearch(arr, N, T);
	if(pos < 0) {
	    printf("target %d not found!\n", T);
	} else {
	    printf("arr[%d]=%d.\n", pos, T);
	}
    }
    return 0;
}

int cmp(const void* a1, const void* a2) {
    return *(int*)a1 - *(int*)a2;
}
