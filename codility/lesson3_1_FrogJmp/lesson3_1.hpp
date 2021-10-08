#include "../basic_io.hpp"
using namespace std;

int solution(int X, int Y, int D) {
	int jump = 0;
	jump = (Y - X) / D;
	if((Y-X)%D > 0) {
		jump++;
	}
	return jump;
}
