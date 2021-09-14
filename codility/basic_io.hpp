#include <bits/stdc++.h>
#define BUFFER_SIZE 1024
char read_buffer[BUFFER_SIZE];

void printVector(std::vector<int> vec) {
    for(int i=0,len=vec.size(); i<len; ++i) {
	if(i < len-1) {
	    std::cout << vec[i] << ' ';
	} else {
	    std::cout << vec[i] << std::endl;
	}
    }
}

/**
 * read single character
 * 读取失败不跳步
 */
bool read_specific(char c, size_t* p_i) {
    if(read_buffer[*p_i] != c) {
	return false;
    }
    (*p_i)++;
#ifdef DEBUG
    printf("read %c ok\n", c);
#endif
    return true;
}

int int_len(int n) {
    int len = 0;
#ifdef DEBUG
    printf("len(%d)", n);
#endif
    if (n < 0) {
	n = -n;
	++len;
    } else if(n == 0) {
	len = 1;
    }
    while(n > 0) {
	n /= 10;
	++len;
    }
#ifdef DEBUG
    printf("=%d\n", len);
#endif
    return len;
}

/**
 * read int number
 */
bool read_int(int* p_num, size_t* p_i) {
    // jump non-number character
    if(! isdigit(read_buffer[*p_i]) && read_buffer[*p_i]!='-') {
        (*p_i)++;
    }
    int num = sscanf(read_buffer+(*p_i), "%d", p_num);
    *p_i += int_len(*p_num);
    return num > 0;
}

/**
 * read into vector<int>
 */
bool readIntVector(std::vector<int>& vec, size_t* p_i) {
    vec.clear();
    size_t len = strlen(read_buffer);
    if(!read_specific('[', p_i)) {
	return false;
    }
    while(read_buffer[*p_i] != ']') {
	if(read_buffer[*p_i] == ',')
	    (*p_i)++;
	int item;
	if (!read_int(&item, p_i))
	    break;
	vec.push_back(item);
    };
    (*p_i)++;
    return true;
}

/**
 * read into vector<vector<int>>
 */
bool read_double_vector_int(std::vector<std::vector<int>>& mat, size_t* p_i) {
    if(! read_specific('[', p_i)) {
        return false;
    }
    while(read_buffer[*p_i] != ']') {
        std::vector<int> row;
        if(! readIntVector(row, p_i)) {
            return false;
        }
        mat.push_back(row);
        read_specific(',', p_i);
    }
    (*p_i)++;
    return true;
}

size_t pre_treat() {
    size_t i = 0;
    size_t len = strlen(read_buffer);
    for(size_t j=0; j<len; ++j) {
	char c = read_buffer[j];
	if(c==' '||c=='\t'||c=='\n')
	    continue;
	read_buffer[i++] = c;
    }
    read_buffer[i] = 0;
#ifdef DEBUG
    printf("read:%s,len=%d\n", read_buffer, i);
#endif
    return i;
}

