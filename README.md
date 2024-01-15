Создание приложения в Андроид студио с несколькими активити:
1. Если несколько активити - каждый надо прописывать в Android.Manifest
2. Для работы binding надо в build.gradle.kts(:app) добавить:
   ```
   viewBinding {
     enable = true
   }
   ```
3. Работа с передачей данных:
   Получение из второй активити:
   ```
   public static Intent createIntent(Context context, String text) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT_KEY, text); //EXTRA_TEXT_KEY - статический ключ для передачи
        return intent;
    }
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String data = getIntent().getStringExtra(EXTRA_TEXT_KEY); //получение самих данных и их запись в переменную
    }
   ```

   В первой активити:
   ```
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Context - класс Android для получения данных ресурсов
        Context context = this;
        String text = context.getResources().getText(R.string.sample_text).toString(); //Получение данных
        
        binding.buttonSecondActivity.setOnClickListener(v -> startSecondActivity());
    }
   private void startSecondActivity() {
        Intent intent = SecondActivity.createIntent(this, "Example text"); //вместо "Example text" надо в этом методе написать получение данных
        startActivityForResult(intent, 100);
    }
   ```
  4. Toast - это всплывающее снизу окно
  5. Intent - хранилище ключей (в этом приложении), поэтому в интент можно сколько угодно данных положить и потом дергать из него данные по разным ключам в разные переменные

   
