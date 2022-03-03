# Barcelona_Players
FCバルセロナの選手一覧を表示するアプリケーション

## Jetpack Composeの使用
Jetpack Composeを使用したアプリケーションです。

特徴として

- Composeを使用したナビゲーション（アニメーションを追加、下部ナビゲーションバーとの統合）
  - マテリアルデザインの原則として、目的地が3つ未満の場合、下部ナビゲーションバーは推奨されていません（詳しくは[こちら](https://material.io/components/bottom-navigation#usage)）が、
    今回はどうしても実装したかったので使用しています。

- [マテリアルコンポーネント](https://material.io/components?platform=android)を使用したレイアウト

- ViewModelを用いた状態管理

などが挙げられます。

アプリの挙動については以下の動画をご覧ください。


https://user-images.githubusercontent.com/77045378/156530914-835d858d-2154-43ff-804a-e90d052c7e77.mp4


