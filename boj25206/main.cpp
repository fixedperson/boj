#include <bits/stdc++.h>

using namespace std;

double scoreToDouble(string s)
{
    if(s.compare("A+") == 0)
    {
        return 4.5;
    }
    else if(s.compare("A0") == 0)
    {
        return 4.0;
    }
    else if(s.compare("B+") == 0)
    {
        return 3.5;
    }
    else if(s.compare("B0") == 0)
    {
        return 3.0;
    }
    else if(s.compare("C+") == 0)
    {
        return 2.5;
    }
    else if(s.compare("C0") == 0)
    {
        return 2.0;
    }
    else if(s.compare("D+") == 0)
    {
        return 1.5;
    }
    else if(s.compare("D0") == 0)
    {
        return 1.0;
    }
    else
    {
        return 0;
    }
}

int main() {
    double totalGrade = 0;
    double totalCredit = 0;

    string s;
    double grade;
    string credit;
    for(int i = 0; i < 20; i++)
    {
        cin >> s >> grade >> credit;

        if(credit.compare("P") == 0) continue;

        totalGrade += grade;
        totalCredit += (scoreToDouble(credit) * grade);
    }

    cout << totalCredit / totalGrade;

    return 0;
}
