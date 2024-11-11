#include <iostream>
using namespace std;

int main() { 
    int saldo = 120000;
    int setor;
    int tarikT;
    int pilihan;
    char lanjut;

    do {
        cout <<"ATM UNISKA\n";
        cout <<"------------------------\n";
        cout <<"1. CEK SALDO\n";
        cout <<"2. SETOR TUNAI\n";
        cout <<"3. TARIK TUNAI\n";
        cout <<"4. KELUAR\n";
        cout <<"------------------------\n";
        cout <<"Pilih menu [1-4] : ";
        cin >> pilihan;

        switch (pilihan) {
            case 1:  
                cout << "Menu 1:\n";    
                cout << "Saldo Anda : " << saldo << endl;
                break;

            case 2: 
                cout << "Menu 2:\n";      
                cout << "Input Setor Tunai : ";
                cin >> setor;

                saldo += setor;
                cout << "Saldo Anda Sekarang : " << saldo << endl;
                break;

            case 3: 
                cout << "Menu 3:\n";  
                cout << "Input Tarik Tunai : ";
                cin >> tarikT;

                if (tarikT <= saldo) {
                    saldo -= tarikT;
                    cout << "Saldo Anda Sekarang : " << saldo << endl;
                } else {
                    cout << "Saldo tidak mencukupi.\n";
                }
                break;

            case 4: 
                cout << "Menu 4:\n";  
                cout << "Terima kasih telah menggunakan ATM UNISKA\n";
                return 0;

            default:
                cout << "Pilihan tidak valid\n";
                break;
        }

        cout << "Lanjut lagi? (Y/T): ";
        cin >> lanjut;
    } while (lanjut == 'Y' || lanjut == 'y');

    cout << "Terima kasih telah menggunakan ATM UNISKA\n";
    return 0;
}
