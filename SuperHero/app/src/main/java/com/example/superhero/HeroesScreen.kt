package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepo
import com.example.superhero.ui.theme.Shapes
import com.example.superhero.ui.theme.SuperHeroTheme

@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            ,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)


        ) {
        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
            .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = stringResource(id = hero.nameStringResource),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionStringResource),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier.size(72.dp).clip(Shapes.small)
            )
            {
                Image(
                    painter = painterResource(id = hero.imageResource),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = stringResource(id = hero.nameStringResource),

                    alignment = Alignment.TopCenter

                )

            }
        }
    }
}

@Composable
fun SuperHeroList(heroes: List<Hero>, modifier: Modifier = Modifier) {

    LazyColumn() {
        items(heroes) { hero ->
            SuperHeroCard(hero, Modifier.padding(16.dp))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperHeroPreview1() {
    SuperHeroTheme {
        SuperHeroList(heroes = HeroesRepo.loadHeroes())
//        SuperHeroCard(hero = Hero(R.drawable.android_superhero1,R.string.android_superhero1,R.string.description1))
    }
}

@Preview(
//    showBackground = true,
//    showSystemUi = true
)
@Composable
fun SuperHeroPreview2() {
    SuperHeroTheme {
//        SuperHeroList(heroes = HeroesRepo.loadHeroes())
        SuperHeroCard(
            hero = Hero(R.drawable.android_superhero1, R.string.android_superhero1, R.string.description1),
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        )
    }
}