typedef pair<int,int> pii;

const int MAX_N = 3003;
int graph[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];

struct cmp {
    bool operator() (const pii& p1, const pii& p2) {
        return p1.second < p2.second;
    }
};

class Solution {
public:
    void initGraph(int (*graph)[MAX_N], int n) {
        for(int i=0; i<n; ++i) {
            memset(graph[i], 0xff, n*sizeof(int));
            graph[i][i] = 0;
        }
    }
    
    void initVisited(int n) {
        for(int i=0; i<n; ++i) {
            memset(visited[i], 0, n*sizeof(bool));
        }
    }
    
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        initGraph(graph, n);
        int minDist[n];    // min dist from 0 to n
        initVisited(n);
        for(vector<int>& e : edges) {
            graph[e[0]][e[1]] = e[2]+1;
            graph[e[1]][e[0]] = e[2]+1;
        }
        int reachable = 0;
        priority_queue<pii, vector<pii>, cmp> q;   // pair<dest point, min dist from 0 to dest>
        for(int point=1; point<n; point++) if(graph[0][point] > 0) {
            int edge = graph[0][point];
            minDist[point] = edge;
            visited[0][point] = true;
            if(maxMoves <= edge) {
                reachable += maxMoves;
                if(maxMoves == edge) {
                    visited[point][0] = true;
                } else {
                    graph[0][point] = graph[point][0] = edge - maxMoves;
                }
            } else {
                reachable += edge;
                q.push(make_pair(point, edge));
            }
        }
        while(! q.empty()) {
            int dest = q.top().first;
            int dist = q.top().second;
            q.pop();
            if(dist > minDist[dest]) continue;
            minDist[dest] = dist;
            for(int neighbor=0;neighbor<n; ++neighbor) if(graph[dest][neighbor] > 0) {
                if(! visited[dest][neighbor]) {
                    if(maxMoves <= dist+graph[dest][neighbor]) {
                        reachable += maxMoves - dist;
                        if(maxMoves == dist+graph[dest][neighbor]) {
                            visited[dest][neighbor] = true;
                        } else {
                            graph[dest][neighbor]=graph[neighbor][dest]=dist+graph[dest][neighbor]-maxMoves;
                        }
                    } else {
                        visited[dest][neighbor] = visited[neighbor][dest] = true;
                        reachable += graph[dest][neighbor];
                        q.push(make_pair(neighbor, dist+graph[dest][neighbor]));
                    }
                }
            }
        }
        return reachable;
    }
};
